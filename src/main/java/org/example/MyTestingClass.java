package org.example;
public class Subjects {
    private String subjectId;

    public Subjects(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Subjects subject = (Subjects) obj;
        return subjectId != null ? subjectId.equals(subject.subjectId) : subject.subjectId == null;
    }
    @Override
    public int hashCode() {
        return subjectId != null ? subjectId.length() : 0;
    }
    @Override
    public String toString() {
        return subjectId;
    }
}
