package in.lingtan.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonInclude(value=Include.NON_NULL)
public class MessageDTO {

	private String infoMessage;

	private boolean infoStatus;

	private String sessionUser;

}
