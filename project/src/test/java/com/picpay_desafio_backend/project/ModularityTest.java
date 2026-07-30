package com.picpay_desafio_backend.project;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTest {
    static ApplicationModules modules = ApplicationModules.of(ProjectApplication.class);

    @Test
    void verifyModularStructure() {
        modules.verify();
    }
}
