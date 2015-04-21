package com.teamd.taxi.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
@Table(name = "groups", schema = "taxi", catalog = "taxiservice")
public class Group {
    private long groupId;
    private float discont;
    private Collection<GroupList> groupList;
    private Collection<User> users;

    @Id
    @Column(name = "group_id")
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "discont")
    public float getDiscont() {
        return discont;
    }

    public void setDiscont(float discont) {
        this.discont = discont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (groupId != group.groupId) return false;
        if (Float.compare(group.discont, discont) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (groupId ^ (groupId >>> 32));
        result = 31 * result + (discont != +0.0f ? Float.floatToIntBits(discont) : 0);
        return result;
    }

    @OneToMany(mappedBy = "groups")
    public Collection<GroupList> getGroupList() {
        return groupList;
    }

    public void setGroupList(Collection<GroupList> groupList) {
        this.groupList = groupList;
    }

    @ManyToMany(mappedBy = "groups")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
