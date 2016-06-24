package by.vsu.mf.ammc.pm.dao;

import by.vsu.mf.ammc.pm.domain.Entity;
import by.vsu.mf.ammc.pm.exception.DaoException;

public interface Dao<PK, T extends Entity> {
	PK create(T object) throws DaoException;

	T read(PK key) throws DaoException;

	void update(T object) throws DaoException;

	void delete(PK key) throws DaoException;
}