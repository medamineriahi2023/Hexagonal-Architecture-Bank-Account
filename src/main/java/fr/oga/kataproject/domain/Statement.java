package fr.oga.kataproject.domain;

import fr.oga.kataproject.infrastructure.enums.Operation;

public record Statement(Long id, Long accountId, Operation operation, float oldBalance, float difference, float newBalance) {

}
