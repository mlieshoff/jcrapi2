package jcrapi2.api.generated.model;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GeneratedModelsTest {

    private final Gson gson = new Gson();

    @Test
    void readsExistingCardsFixtureWithTheWrappersGsonSerializer() throws IOException {
        Items cards = readFixture("card-findAll.json", Items.class);

        assertFalse(cards.getItems().isEmpty());
        assertNull(cards.getSupportItems(), "Absent arrays must remain absent when serialized");
        Item knight = cards.getItems().getFirst();
        assertEquals("Knight", knight.getName());
        assertEquals(26000000, knight.getId());
        assertEquals(14, knight.getMaxLevel());
        assertTrue(knight.getIconUrls().getMedium()
                .startsWith("https://api-assets.clashroyale.com/"));
        assertEquals(cards, gson.fromJson(gson.toJson(cards), Items.class));
    }

    @Test
    void readsExistingPlayerFixtureIncludingNestedModels() throws IOException {
        Player player = readFixture("player-findByTag.json", Player.class);

        assertEquals("#2PGGCJJL", player.getTag());
        assertEquals("micah", player.getName());
        assertFalse(player.getCards().isEmpty());
        assertNotNull(player.getClan());
        assertEquals(Player.RoleEnum.LEADER, player.getRole());
        assertEquals(player, gson.fromJson(gson.toJson(player), Player.class));
    }

    @Test
    void readsSupportItemsAndIgnoresAdditionalResponseFields() {
        Items cards = gson.fromJson("""
                {
                  "items": [],
                  "supportItems": [{"id": 159000000, "name": "Tower", "maxLevel": 15}],
                  "futureField": true
                }
                """, Items.class);

        assertTrue(cards.getItems().isEmpty());
        assertEquals(1, cards.getSupportItems().size());
        assertEquals("Tower", cards.getSupportItems().getFirst().getName());
        assertEquals(159000000, cards.getSupportItems().getFirst().getId());
    }

    private <T> T readFixture(String name, Class<T> type) throws IOException {
        try (var reader = new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/" + name)),
                StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, type);
        }
    }
}
