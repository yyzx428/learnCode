package scanner.annotation.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class CycleEntity {
    @Autowired
    private CycleEntity cycleEntity;
    private String name;

    public CycleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CycleEntity getCycleEntity() {
        return cycleEntity;
    }
}
