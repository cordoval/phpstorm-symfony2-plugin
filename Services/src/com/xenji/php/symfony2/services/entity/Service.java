package com.xenji.php.symfony2.services.entity;

import com.intellij.openapi.vfs.VirtualFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 02/06/12
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class Service {

    private String serviceId;

    private VirtualFile fileLocation;

    private String serviceName;

    private List<ImplCandidate> implCandidateList = new ArrayList<ImplCandidate>();

    private List<String> tags;

    private Service parentService;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public VirtualFile getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(VirtualFile fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<ImplCandidate> getImplCandidateList() {
        return implCandidateList;
    }

    public void setImplCandidateList(List<ImplCandidate> implCandidateList) {
        this.implCandidateList = implCandidateList;
    }

    public void addImplCandidate(ImplCandidate implCandidate) {
        this.implCandidateList.add(implCandidate);
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);

    }

    public boolean hasParentService() {
        return parentService != null;
    }

    public Service getParentService() {
        return parentService;
    }

    public void setParentService(Service parentService) {
        this.parentService = parentService;
    }
}
