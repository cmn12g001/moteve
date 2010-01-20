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

package com.moteve.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Radek Skokan
 */
@Entity
@Table(name="video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="permanent")
    private boolean permanent;

    @Column(name="creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name="record_in_progress")
    private boolean recordInProgress;

    @OneToMany(mappedBy="video")
    private Set<VideoPart> parts;

    @ManyToOne(optional=false)
    private User author;

    @ManyToMany
    @JoinTable(
        name="video_permission",
        joinColumns=@JoinColumn(name="video_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    private Set<Role> permissions;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VideoPart> getParts() {
        return parts;
    }

    public void setParts(Set<VideoPart> parts) {
        this.parts = parts;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Set<Role> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Role> permissions) {
        this.permissions = permissions;
    }

    public boolean isRecordInProgress() {
        return recordInProgress;
    }

    public void setRecordInProgress(boolean recordInProgress) {
        this.recordInProgress = recordInProgress;
    }
    
}
