package org.softuni.AFIF.integration.serviceTests;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.softuni.AFIF.web.domain.entities.Player;
import org.softuni.AFIF.web.repositories.PlayerRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlayerServiceTests {

    private Player player;

    @MockBean
    private PlayerRepository mockedPlayerRepository;

    @Before
    public void init()
    {
        this.player.setId("id");
        this.player.setFirstName("gosho");
        this.player.setLastName("pesho");
        this.player.setDefending(80);
        this.player.setDribbling(80);
        this.player.setHeight(180);
        this.player.setOverallRating(86);
        this.player.setPace(90);
        this.player.setPhysical(86);
        this.player.setPassing(76);
        this.player.setShooting(88);
        this.player.setWeakFoot(5);
        this.player.setSkillMoves(4);
        this.player.setPrice(80000);
        this.player.setPosition("GK");
        this.mockedPlayerRepository = Mockito.mock(PlayerRepository.class);
    }
}
