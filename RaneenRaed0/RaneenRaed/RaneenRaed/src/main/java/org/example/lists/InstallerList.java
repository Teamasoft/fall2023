package org.example.lists;

import org.example.model.Installer;

import java.util.ArrayList;
import java.util.List;

public class InstallerList {


        private static List<Installer> installerList = new ArrayList<>();

        public static List<Installer> getInstallerList() {
            return installerList;
        }

        public static void setInstallerList(List<Installer> installerList) {
            InstallerList.installerList = installerList;
        }

        public static void addInstaller(Installer installer){
            installerList.add(installer);
        }

        private InstallerList(){
            //for code smell
        }












}
