package com.status.service.impl;

import com.status.mapper.PlayRecordMapper;
import com.status.model.entity.PlayRecord;
import com.status.service.PlayRecordServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张志宇
 * @version V1.0
 * @Package com.status.service
 * @date 2021/3/4 16:14
 */
@Service
public class PlayRecordServieImpl implements PlayRecordServie {

    @Autowired
    private PlayRecordMapper playRecordMapper;
    @Override
    public Integer updatePlayLog(PlayRecord playRecord) {
        return playRecordMapper.updateByPrimaryKey(playRecord);
    }

    @Override
    public PlayRecord selectPlayLog(PlayRecord playRecord) {
        return playRecordMapper.selectPlayLog(playRecord);
    }

    @Override
    public Integer insertPlayLog(PlayRecord playRecord) {
        return playRecordMapper.insert(playRecord);
    }
}
