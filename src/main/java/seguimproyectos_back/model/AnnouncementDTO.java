package seguimproyectos_back.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnnouncementDTO {

	/**
	 * The unique identifier for the announcement.
	 * <p>
	 * This ID is typically used to identify the announcement in the database or
	 * other systems.
	 * </p>
	 */
	private Long id;

	/**
	 * The name of the announcement.
	 * <p>
	 * This field stores the name or title of the announcement, which could
	 * represent an event, news, or other types of announcements.
	 * </p>
	 */
	private String name;
}
