package fr.oga.kataproject.application.dao;

import fr.oga.kataproject.application.dto.StatementDto;

import java.util.List;

public interface StatementDao {
   void saveStatement(StatementDto statementDto);

   List<StatementDto> getAllStatements(Long accountId);



}
