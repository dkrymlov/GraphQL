package org.example;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {

  private final GraphQL graphQL;

  @Autowired
  GraphQLController(GraphQL graphQL) {
    this.graphQL = graphQL;
  }

  @PostMapping(path = "graphql",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ExecutionResult graphql(@RequestBody EntryPoint entryPoint,
      @RequestParam String columnIndex, @RequestParam String value, @RequestParam String operator) {
    DBManager.populateTable();
    DBManager.updateTable(Integer.parseInt(columnIndex),value, operator);
    ExecutionInput executionInput = ExecutionInput.newExecutionInput()
        .query(entryPoint.query)
        .build();
    return graphQL.execute(executionInput);
  }

  public static class EntryPoint {
    public String query;
  }
}
