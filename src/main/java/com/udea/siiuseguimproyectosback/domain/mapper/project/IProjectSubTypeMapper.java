package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectSubTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectSubType;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjectSubTypeMapper extends IEntityMapper<ProjectSubTypeDTO, ProjectSubType> {
}
