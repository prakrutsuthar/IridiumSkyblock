package com.iridium.iridiumskyblock;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.database.User;

public class UserBuilder {
    private final PlayerMock playerMock;
    private final User user;

    public UserBuilder(ServerMock serverMock) {
        this.playerMock = serverMock.addPlayer();
        this.user = IridiumSkyblock.getInstance().getUserManager().getUser(playerMock);
    }

    public UserBuilder(ServerMock serverMock, String playerName) {
        this.playerMock = serverMock.addPlayer(playerName);
        this.user = IridiumSkyblock.getInstance().getUserManager().getUser(playerMock);
    }


    public UserBuilder withIsland(Island island) {
        //method moved from here
        this.user.withIsland(island);
        return this;
    }

    public UserBuilder withIslandRank(IslandRank islandRank) {
        user.setIslandRank(islandRank);
        return this;
    }

    public UserBuilder setBypassing() {
        user.setBypassing(true);
        return this;
    }

    public PlayerMock build() {
        return playerMock;
    }

}
