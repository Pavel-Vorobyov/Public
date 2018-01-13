package by.vorobyov.training.database.creator;

import by.vorobyov.training.database.dao.util.columnname.UserColumnName;
import by.vorobyov.training.database.dao.util.columnname.UserDataColumnName;
import by.vorobyov.training.database.dao.util.columnname.WorkGroupColumnName;
import by.vorobyov.training.entity.User;
import by.vorobyov.training.entity.WorkGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class WorkGroupCreator {
    public WorkGroupCreator() {
    }

    public List<WorkGroup> createWorkGroupList(ResultSet resultSet) throws SQLException {
        List<WorkGroup> workGroupList = new LinkedList<>();

        while (resultSet.next()) {
            WorkGroup workGroup = createWorkGroup(resultSet);
            workGroupList.add(workGroup);
        }

        return workGroupList;
    }

    public WorkGroup createWorkGroup(ResultSet resultSet) throws SQLException {
        WorkGroup workGroup = new WorkGroup();

        workGroup.setWorkGroupId(resultSet.getInt(WorkGroupColumnName.ID));
        workGroup.setTitle(resultSet.getString(WorkGroupColumnName.TITLE));
        workGroup.setDescription(resultSet.getString(WorkGroupColumnName.DESCRIPTION));
        workGroup.setLeadId(resultSet.getInt(WorkGroupColumnName.LEAD_ID));
        workGroup.setCourseId(resultSet.getInt(WorkGroupColumnName.COURSE_ID));

        return workGroup;
    }
}
