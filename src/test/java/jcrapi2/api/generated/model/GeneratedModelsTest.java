package jcrapi2.api.generated.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

class GeneratedModelsTest {

    private final Gson gson = new Gson();

    @Test
    void fromJson_whenCardsFixture_thenPreserveCardsAndAbsentArrays() throws IOException {
        Items cards = readFixture("card-findAll.json", Items.class);

        assertCardsFixture(cards);
    }

    @Test
    void fromJson_whenPlayerFixture_thenPreserveNestedModels() throws IOException {
        Player player = readFixture("player-findByTag.json", Player.class);

        assertPlayerFixture(player);
    }

    @Test
    void fromJson_whenSupportItemsAndUnknownFields_thenReadSupportItems() {
        Items cards =
                gson.fromJson(
                        """
                        {
                          "items": [],
                          "supportItems": [{"id": 159000000, "name": "Tower", "maxLevel": 15}],
                          "futureField": true
                        }
                        """,
                        Items.class);

        assertSupportItems(cards);
    }

    private void assertCardsFixture(Items cards) {
        assertThat(cards.getItems()).isNotEmpty();
        assertThat(cards.getSupportItems())
                .as("Absent arrays must remain absent when serialized")
                .isNull();
        Item knight = cards.getItems().getFirst();
        assertThat(knight.getName()).isEqualTo("Knight");
        assertThat(knight.getId()).isEqualTo(26000000);
        assertThat(knight.getMaxLevel()).isEqualTo(14);
        assertThat(knight.getIconUrls().getMedium())
                .startsWith("https://api-assets.clashroyale.com/");
        assertThat(gson.fromJson(gson.toJson(cards), Items.class)).isEqualTo(cards);
    }

    private void assertPlayerFixture(Player player) {
        assertThat(player.getTag()).isEqualTo("#2PGGCJJL");
        assertThat(player.getName()).isEqualTo("micah");
        assertThat(player.getCards()).isNotEmpty();
        assertThat(player.getClan()).isNotNull();
        assertThat(player.getRole()).isEqualTo(Player.RoleEnum.LEADER);
        assertThat(gson.fromJson(gson.toJson(player), Player.class)).isEqualTo(player);
    }

    private void assertSupportItems(Items cards) {
        assertThat(cards.getItems()).isEmpty();
        assertThat(cards.getSupportItems()).hasSize(1);
        assertThat(cards.getSupportItems().getFirst().getName()).isEqualTo("Tower");
        assertThat(cards.getSupportItems().getFirst().getId()).isEqualTo(159000000);
    }

    private <T> T readFixture(String name, Class<T> type) throws IOException {
        try (var reader =
                new InputStreamReader(
                        Objects.requireNonNull(getClass().getResourceAsStream("/" + name)),
                        StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, type);
        }
    }
}
