package com.example.systemserver.provider;

import com.example.systemserver.model.*;
import com.example.systemserver.model.Module;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Component
public class MockDataProvider {

    public List<Module> getModules() {
        return List.of(
            new Module(1, "ElementaryChemistry", 4, """
                Module ElementaryChemistry: 4;
                Begin
                  Sort atomicProperty: {}N;
                  (PropertyValue In atomicProperty) Sort PropertyValue: {}I U {}R U {}N;
                  molar_volume = 22.4;
                End;
                Param atomicProperty: 4;
                """),
            new Module(2, "ReactionTypes", 4,"""
                Module ReactionTypes: 4;
                Begin
                  Sort reactionStage: {}N;
                  (stage In reactionStage) Sort StageID: {}I => {}N;
                End;
                Param reactionStage: 4;
                """),
            new Module(3, "SolubilitySystem", 3,"""
                Module SolubilitySystem: 3;
                Begin
                  Sort solute: {}N;
                  Sort solubility: {}N;
                  Sort solubilityRule: solute => solubility;
                End;
                Param solute: 3;
                Param solubility: 3;
                """),
            new Module(4, "Химия", 4, ""),
            new Module(5, "Химия", 3, ""),
            new Module(6, "Химия", 2, ""),
            new Module(7, "Химия", 1, ""),
            new Module(8, "Прототип", 2, ""),
            new Module(9, "Прототип", 1, ""),
            new Module(10, "Попытка", 1, ""),
            new Module(11, "Слова", 2, ""),
            new Module(12, "Слова", 1, "")
        );
    }

    public List<User> getUsers() {
        return List.of(
            new User(1, "Василий Сергеев", null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
            new User(2, "Матвей Глазырин", null, null, "\\View\\Images\\roles\\roleViewerIcon.png"),
            new User(3, "Старцев Денис", null, null, "\\View\\Images\\roles\\roleEditorIcon.png"),
            new User(4, "Раздобаров Данила", "kiril", "444", "\\View\\Images\\roles\\roleEditorIcon.png"),
            new User(5, "Терехин Богдан", "tom", "555", "\\View\\Images\\roles\\roleViewerIcon.png")
        );
    }

    public List<Project> getProjects() {
        return List.of(
            new Project(1, "Химия",
                List.of(
                    new User(1, "Василий Сергеев", null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
                    new User(2, "Матвей Глазырин", null, null, "\\View\\Images\\roles\\roleViewerIcon.png"),
                    new User(3, "Старцев Денис", null, null, "\\View\\Images\\roles\\roleEditorIcon.png")
                ),
                "Василий Сергеев", LocalDateTime.of(2025, 7, 1, 14, 30).toString(),
                "\\View\\Images\\roles\\roleOwnerIcon.png", List.of(1, 2, 3),
                "Версия 2.0"
            ),
            new Project(1, "Химия",
                List.of(new User(1, "Василий Сергеев", null, null, "\\View\\Images\\roles\\roleOwnerIcon.png")),
                "Василий Сергеев", LocalDateTime.of(2025, 6, 17, 19, 35).toString(),
                "\\View\\Images\\roles\\roleOwnerIcon.png", List.of(1, 2), "Версия 1.0"),
            new Project(3, "Биология",
                List.of(
                    new User(3, null, null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
                    new User(2, null, null, null, "\\View\\Images\\roles\\roleEditorIcon.png")
                ),
                "Денис Старцев", LocalDateTime.of(2024, 7, 2, 18, 45).toString(),
                "\\View\\Images\\roles\\roleEditorIcon.png", List.of(8, 9), "Версия 1.0"),
            new Project(4, "Алгоритмы",
                List.of(
                    new User(1, null, null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
                    new User(4, null, null, null, "\\View\\Images\\roles\\roleEditorIcon.png")
                ),
                "Терехин Богдан", LocalDateTime.of(2011, 1, 1, 0, 0).toString(),
                "\\View\\Images\\roles\\roleEditorIcon.png", List.of(10), "Версия 1.0"),
            new Project(5, "История",
                List.of(
                    new User(5, null, null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
                    new User(4, null, null, null, "\\View\\Images\\roles\\roleEditorIcon.png")
                ),
                "Раздобаров Данила", LocalDateTime.of(2022, 12, 21, 23, 59).toString(),
                "\\View\\Images\\roles\\roleEditorIcon.png", List.of(11, 12 ), "Версия 1.0"
            ),

            new Project(6, "Физика",
                List.of(
                    new User(2, null, null, null, "\\View\\Images\\roles\\roleOwnerIcon.png"),
                    new User(5, "Матвей Глазырин", null, null, "\\View\\Images\\roles\\roleViewerIcon.png"),
                    new User(1, "Василий Сергеев", null, null, "\\View\\Images\\roles\\roleViewerIcon.png")
                ),
                "Матвей Глазырин", LocalDateTime.of(2022, 7, 1, 9, 15).toString(),
                "\\View\\Images\\roles\\roleViewerIcon.png", List.of(4, 5, 6, 7), "Версия 1.0")
        );
    }
}
