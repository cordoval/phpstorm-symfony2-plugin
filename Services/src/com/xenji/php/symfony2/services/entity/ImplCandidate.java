package com.xenji.php.symfony2.services.entity;

import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 02/06/12
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class ImplCandidate {

    private Service service;

    private String classname;

    private VirtualFile fileLocation;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public VirtualFile getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(VirtualFile fileLocation) {
        this.fileLocation = fileLocation;
    }
}
