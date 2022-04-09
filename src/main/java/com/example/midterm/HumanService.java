package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanService {

    private final HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public List<Human> getPeople() {
        return humanRepository.findAll();
    }

    public Human createHuman(Human human) {
        return humanRepository.save(human);
    }

    public Human getHumanById(Long humanId) {
        return humanRepository.getById(humanId);
    }

    public void deleteHuman(Long humanId) {
        humanRepository.deleteById(humanId);
    }
}
