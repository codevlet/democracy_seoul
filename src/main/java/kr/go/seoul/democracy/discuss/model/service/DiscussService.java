package kr.go.seoul.democracy.discuss.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

public interface DiscussService {

	ArrayList<Discuss> discussList(int pageSize,int currentListPage);
	
	int discussTotalCount();

	Discuss discussOne(int discussNo);

	ArrayList<HashMap<String, Object>> proComment(int discussNo,int pageSize,int currentCommentPage);

	ArrayList<HashMap<String, Object>> conComment(int discussNo,int pageSize,int currentCommentPage);
	
	int commentTotalCount(int discussNo);

	ArrayList<DiscussFile> file(int discussNo);

	int write(Discuss discuss);

	ArrayList<HashMap<String, Object>> getComment(int discussNo, int currentCommentPage, int pageSize);

	int writeComment(HashMap<String, Object> comment);

	HashMap<String, Object> myComment(int discussNo, String userId);

	int vote(HashMap<String, Object> vote);

	HashMap<String, Object> getVote(int discussNo);

	ArrayList<Discuss> getList(int currentListPage, int pageSize);

	int fileUpload(HashMap<String, Object> file);

	int fileUpdate(int fileNo, int discussNo);

}
