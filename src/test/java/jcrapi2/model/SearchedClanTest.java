/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jcrapi2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Generated("org.mili.generator")
public class SearchedClanTest {

    private SearchedClan unitUnderTest;

    @BeforeEach
    public void setUp() {
        unitUnderTest = new SearchedClan();
    }

    @Test
    public void shouldGetSetTag() {
        String expected = "astring";
        unitUnderTest.setTag(expected);
        assertEquals(expected, unitUnderTest.getTag());
    }

    @Test
    public void shouldGetSetName() {
        String expected = "astring";
        unitUnderTest.setName(expected);
        assertEquals(expected, unitUnderTest.getName());
    }

    @Test
    public void shouldGetSetType() {
        String expected = "astring";
        unitUnderTest.setType(expected);
        assertEquals(expected, unitUnderTest.getType());
    }

    @Test
    public void shouldGetSetBadgeId() {
        int expected = 815;
        unitUnderTest.setBadgeId(expected);
        assertEquals(expected, unitUnderTest.getBadgeId());
    }

    @Test
    public void shouldGetSetClanScore() {
        int expected = 815;
        unitUnderTest.setClanScore(expected);
        assertEquals(expected, unitUnderTest.getClanScore());
    }

    @Test
    public void shouldGetSetLocation() {
        SearchedClanLocation expected = new SearchedClanLocation();
        unitUnderTest.setLocation(expected);
        assertEquals(expected, unitUnderTest.getLocation());
    }

    @Test
    public void shouldGetSetRequiredTrophies() {
        int expected = 815;
        unitUnderTest.setRequiredTrophies(expected);
        assertEquals(expected, unitUnderTest.getRequiredTrophies());
    }

    @Test
    public void shouldGetSetDonationsPerWeek() {
        int expected = 815;
        unitUnderTest.setDonationsPerWeek(expected);
        assertEquals(expected, unitUnderTest.getDonationsPerWeek());
    }

    @Test
    public void shouldGetSetClanChestLevel() {
        int expected = 815;
        unitUnderTest.setClanChestLevel(expected);
        assertEquals(expected, unitUnderTest.getClanChestLevel());
    }

    @Test
    public void shouldGetSetClanChestMaxLevel() {
        int expected = 815;
        unitUnderTest.setClanChestMaxLevel(expected);
        assertEquals(expected, unitUnderTest.getClanChestMaxLevel());
    }

    @Test
    public void shouldGetSetMembers() {
        int expected = 815;
        unitUnderTest.setMembers(expected);
        assertEquals(expected, unitUnderTest.getMembers());
    }

    @Test
    public void shouldToString() {
        unitUnderTest.setTag("astring");
        unitUnderTest.setName("astring");
        unitUnderTest.setType("astring");
        unitUnderTest.setBadgeId(815);
        unitUnderTest.setClanScore(815);
        unitUnderTest.setLocation(new SearchedClanLocation());
        unitUnderTest.setRequiredTrophies(815);
        unitUnderTest.setDonationsPerWeek(815);
        unitUnderTest.setClanChestLevel(815);
        unitUnderTest.setClanChestMaxLevel(815);
        unitUnderTest.setMembers(815);
        String expected = "SearchedClan(tag=astring, name=astring, type=astring, badgeId=815, clanScore=815, location=" + new SearchedClanLocation() + ", requiredTrophies=815, donationsPerWeek=815, clanChestLevel=815, clanChestMaxLevel=815, members=815)";
        String actual = unitUnderTest.toString();
        assertEquals(expected, actual);
    }

}