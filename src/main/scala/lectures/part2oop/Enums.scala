package com.raunakjodhawat
package lectures.part2oop

object Enums extends App {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("Opening document")
      else println("reading not allowed")
  }
  val somePermissions: Permissions = Permissions.READ
  somePermissions.openDocument()

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.READ
  }

  // Standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  println(somePermissionsOrdinal)

  val allPermissions = Permissions.values
  println(allPermissions.mkString(", "))

  val readPermission: Permissions = Permissions.valueOf("READ")
  println(readPermission)
}
