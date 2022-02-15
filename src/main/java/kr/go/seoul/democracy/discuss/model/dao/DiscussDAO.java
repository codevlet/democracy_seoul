package kr.go.seoul.democracy.discuss.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Repository
public class DiscussDAO {

   @Resource(name="sqlSessionTemplate")
   private SqlSessionTemplate sqlSession;

   public ArrayList<Discuss> discussList(int pageSize, int currentListPage) {
      RowBounds rb=new RowBounds((currentListPage-1)*pageSize,pageSize);
      return new ArrayList<Discuss>(sqlSession.selectList("discuss.list",null,rb));
   }

   public int discussTotalCount() {
      return sqlSession.selectOne("discuss.discussTotalCount");
   }

   public Discuss discussOne(int discussNo) {
      return sqlSession.selectOne("discuss.onePost",discussNo);
   }

   public ArrayList<HashMap<String,Object>> proComment(int discussNo,int pageSize,int currentCommentPage) {
      RowBounds rb=new RowBounds((currentCommentPage-1)*pageSize,pageSize);
      return new ArrayList<HashMap<String,Object>>(sqlSession.selectList("discuss.proCommentList",discussNo,rb));
   }

   public ArrayList<HashMap<String,Object>> conComment(int discussNo,int pageSize,int currentCommentPage) {
      RowBounds rb=new RowBounds((currentCommentPage-1)*pageSize,pageSize);
      return new ArrayList<HashMap<String,Object>>(sqlSession.selectList("discuss.conCommentList",discussNo,rb));
   }

   public int commentTotalCount(int discussNo) {
      return sqlSession.selectOne("discuss.commentTotalCount", discussNo);
   }

   public ArrayList<DiscussFile> file(int discussNo) {
      return new ArrayList<DiscussFile>(sqlSession.selectList("discuss.fileList"));
   }

	public int write(Discuss discuss) {
		return sqlSession.insert("discuss.write", discuss);
	}
	
	public ArrayList<HashMap<String, Object>> getComment(int discussNo, int currentCommentPage, int pageSize) {
		RowBounds rb=new RowBounds((currentCommentPage-1)*pageSize,pageSize);
	    return new ArrayList<HashMap<String,Object>>(sqlSession.selectList("discuss.commentList",discussNo,rb));
	}

	public int writeComment(HashMap<String, Object> comment) {
		return sqlSession.insert("discuss.writeComment", comment);
	}

	public HashMap<String, Object> myComment(int discussNo, String userId) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("discussNo", discussNo);
		map.put("userId", userId);
		return sqlSession.selectOne("discuss.myComment", map);
	}

	public int vote(HashMap<String, Object> vote) {
		return sqlSession.update("discuss.vote", vote);
	}

	public HashMap<String, Object> getVote(int discussNo) {
		return sqlSession.selectOne("discuss.getVote", discussNo);
	}

	public ArrayList<Discuss> getList(int currentListPage, int pageSize) {
		RowBounds rb=new RowBounds((currentListPage-1)*pageSize,pageSize);
	    return new ArrayList<Discuss>(sqlSession.selectList("discuss.getList",null,rb));
	}

	public int fileUpload(HashMap<String, Object> file) {
		return sqlSession.update("discuss.fileUpload", file);
	}
	
	public int fileUpdate(int discussNo, int fileNo) {
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("discussNo", discussNo);
		map.put("fileNo", fileNo);
		return sqlSession.update("discuss.fileUpdate", map);
	}

}