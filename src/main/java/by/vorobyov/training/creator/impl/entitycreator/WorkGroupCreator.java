package by.vorobyov.training.creator.impl.entitycreator;

import by.vorobyov.training.creator.ICreator;
import by.vorobyov.training.database.dao.util.columnname.WorkGroupColumnName;
import by.vorobyov.training.dto.entity.WorkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WorkGroupCreator implements ICreator<WorkGroup> {
    public WorkGroupCreator() {
    }

    @Override
    public List<WorkGroup> createEntityList(ResultSet resultSet) throws SQLException {
        List<WorkGroup> workGroupList = new LinkedList<>();

        if (resultSet.next()) {
            do {
                WorkGroup workGroup = createEntity(resultSet);
                workGroupList.add(workGroup);
            } while (resultSet.next());
        } else {
            return Collections.emptyList();
        }

        return workGroupList;
    }

    @Override
    public WorkGroup createEntity(ResultSet resultSet) throws SQLException {
        WorkGroup workGroup = new WorkGroup();

        workGroup.setWorkGroupId(resultSet.getInt(WorkGroupColumnName.ID));
        workGroup.setTitle(resultSet.getString(WorkGroupColumnName.TITLE));
        workGroup.setDescription(resultSet.getString(WorkGroupColumnName.DESCRIPTION));
        workGroup.setLeadId(resultSet.getInt(WorkGroupColumnName.LEAD_ID));
        workGroup.setCourseId(resultSet.getInt(WorkGroupColumnName.COURSE_ID));

        return workGroup;
    }
}
