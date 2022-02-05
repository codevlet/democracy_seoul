package kr.go.seoul.democracy.discuss.model.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussComment;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Repository
public class DiscussDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public ArrayList<Discuss> discussList() {
		return new ArrayList<Discuss>(sqlSession.selectList("discuss.list"));
	}

	public Discuss discussOne(int discussNo) {
		return sqlSession.selectOne("discuss.onePost",discussNo);
	}

	public ArrayList<DiscussComment> proComment(int discussNo) {
		return new ArrayList<DiscussComment>(sqlSession.selectList("discuss.proCommentList"));
	}

	public ArrayList<DiscussComment> conComment(int discussNo) {
		return new ArrayList<DiscussComment>(sqlSession.selectList("discuss.conCommentList"));
	}

	public ArrayList<DiscussFile> file(int discussNo) {
		return new ArrayList<DiscussFile>(sqlSession.selectList("discuss.fileList"));
	}
}