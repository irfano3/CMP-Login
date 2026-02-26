package com.o3.cmplogin.project

import javax.swing.JOptionPane

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun showToast(message: String) {
    JOptionPane.showMessageDialog(null, message)
}