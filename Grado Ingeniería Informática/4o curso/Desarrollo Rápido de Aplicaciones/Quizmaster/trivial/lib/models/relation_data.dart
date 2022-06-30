class RelationData {
  String _id = "";
  String _idQuestion = "";
  String _idUser = "";

  RelationData(this._id, this._idQuestion, this._idUser);

  String get id => this._id;
  set id(String value) => this._id = value;

  String get idQuestion => this._idQuestion;
  set idQuestion(String value) => this._idQuestion = value;

  String get idUser => this._idUser;
  set idUser(String value) => this._idUser = value;

  factory RelationData.fromJson(Map<String, dynamic> json) {
    return RelationData(json["id"], json["idQuestion"], json["idUser"]);
  }

  Map<String, dynamic> toJson() {
    return {
      "id": this._id,
      "idQuestion": this._idQuestion,
      "idUser": this._idUser
    };
  }
}
