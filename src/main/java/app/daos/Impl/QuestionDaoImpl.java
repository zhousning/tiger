package app.daos.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.daos.QuestionDao;
import app.daos.RoleDao;
import app.models.Question;
import app.models.Role;
import app.models.User;

@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao{

}
