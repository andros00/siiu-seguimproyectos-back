package seguimproyectos_back.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectionProcessDTO {

	private Long id;

	private String name;
}