package org.softuni.AFIF.integration.serviceTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.AFIF.web.domain.serviceModels.ManagerServiceModel;
import org.softuni.AFIF.web.repositories.ManagerRepository;
import org.softuni.AFIF.web.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerServiceTests {

    @MockBean
    private ManagerRepository mockedManagerRepository;

    @Autowired
    private ManagerService managerService;

    @Test
    public void passingValidManagerShouldCreateManager()
    {
        ManagerServiceModel managerServiceModel = new ManagerServiceModel();

        when(mockedManagerRepository.save(any()));
        verify(mockedManagerRepository)
                .save(any());
    }
}
