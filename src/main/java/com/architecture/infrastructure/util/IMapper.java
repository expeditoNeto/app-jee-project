package com.architecture.infrastructure.util;

import java.util.List;

public interface IMapper {
	<D> D map(Object source, Class<D> destinationType);
	void map(Object source, Object destination);
	<D> List<D> map(List<?> source, Class<D[]> destinationType);
}
