class UserData {
  String _id = "";
  String _name = "";
  String _mail = "";
  String _password = "";

  UserData(String id, String name, String mail, {String? password}) {
    this._id = id;
    this._name = name;
    this._mail = mail;
    this._password = password ?? "";
  }

  String get id => this._id;
  set id(String value) => this._id = value;

  String get name => this._name;
  set name(String value) => this._name = value;

  String get mail => this._mail;
  set mail(String value) => this._mail = value;

  String get password => this._password;
  set password(String value) => this._password = value;

  factory UserData.fromJson(Map<String, dynamic> json) {
    return UserData(json["id"], json["name"], json["mail"]);
  }

  Map<String, dynamic> toJson() {
    return {"id": this._id, "name": this._name, "mail": this._mail};
  }
}
