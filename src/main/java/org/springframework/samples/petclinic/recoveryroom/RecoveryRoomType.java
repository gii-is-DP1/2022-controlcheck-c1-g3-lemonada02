package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="recoveryroomtypes")
public class RecoveryRoomType extends BaseEntity{
	@NotNull
	@Size(min=5, max=50)
	private String name;

	public String getName() {
		return this.name;
	}

}
