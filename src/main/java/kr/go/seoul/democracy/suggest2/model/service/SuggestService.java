package kr.go.seoul.democracy.suggest2.model.service;

import kr.go.seoul.democracy.suggest2.model.vo.Suggest;

import java.util.HashMap;

public interface SuggestService {
    boolean insertPost(Suggest suggest);
    boolean updatePost(Suggest suggest);
    Suggest selectPost(int suggestNo);
}
