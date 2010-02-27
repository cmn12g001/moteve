/*
 * Copyright 2009-2010 Moteve.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moteve.dao;

import com.moteve.domain.Video;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Radek Skokan
 */
@Repository
public class VideoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Video store(Video video) {
        return entityManager.merge(video);
    }

    @Transactional
    public void delete(Long videoId) {
        Video video = entityManager.find(Video.class, videoId);
        entityManager.remove(video);
    }

    @Transactional(readOnly = true)
    public Video findById(Long videoId) {
        return entityManager.find(Video.class, videoId);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Video> findAll() {
        Query query = entityManager.createQuery("SELECT v FROM Video v");
        return query.getResultList();
    }
}