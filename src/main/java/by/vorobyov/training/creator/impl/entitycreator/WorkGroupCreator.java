package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.AbstractCreator;
import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.columnname.WorkGroupColumnName;
import by.vorobyov.training.dto.entity.WorkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WorkGroupCreator extends AbstractCreator<WorkGroup> implements ICreator<WorkGroup> {
    @Override
    public WorkGroup createEntity(ResultSet resultSet) throws SQLException {
        WorkGroup workGroup = new WorkGroup();

        workGroup.setWorkGroupId(resultSet.getInt(WorkGroupColumnName.ID));
        workGroup.setTitle(resultSet.getString(WorkGroupColumnName.TITLE));
        workGroup.setDescription(resultSet.getString(WorkGroupColumnName.DESCRIPTION));
        workGroup.setLeadId(resultSet.getInt(WorkGroupColumnName.LEAD_ID));
        workGroup.setCourseId(resultSet.getInt(WorkGroupColumnName.COURSE_ID));
        workGroup.setRegion(resultSet.getString(WorkGroupColumnName.REGION));
        workGroup.setType(resultSet.getString(WorkGroupColumnName.TYPE));
        workGroup.setStatus(resultSet.getInt(WorkGroupColumnName.STATUS));

        return workGroup;
    }
}
