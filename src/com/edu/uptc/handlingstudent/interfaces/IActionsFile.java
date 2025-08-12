package com.edu.uptc.handlingstudent.interfaces;

import com.edu.uptc.handlingstudent.enums.ETypeFileEnum;

public interface IActionsFile {
	public void loadFile(ETypeFileEnum eTypeFileEnum);
	public void dumpFile(ETypeFileEnum eTypeFileEnum);
}
