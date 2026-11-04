
package com.hibernate.services;

import com.hibernate.dao.IDao;
import com.hibernate.dao.MachineDao;
import com.hibernate.entities.Machine;

import java.util.List;

public class MachineService implements IDao<Machine> {

    private IDao<Machine> dao = new MachineDao();

    @Override
    public boolean create(Machine o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(Machine o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(Machine o) {
        return dao.update(o);
    }

    @Override
    public Machine getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Machine> getAll() {
        return dao.getAll();
    }
}
