import 'package:flutter/material.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';
import 'package:lab3_ma/UI/CreatePage.dart';
import 'package:lab3_ma/UI/DeletePage.dart';
import 'package:lab3_ma/UI/ReadPage.dart';
import 'package:lab3_ma/UI/UpdatePage.dart';

class MainPage extends StatefulWidget {
  MainPage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {

  @override
  Widget build(BuildContext context) {
    VegetableRepo vegetableRepo = new VegetableRepo();
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              FlatButton(
                  color: Colors.amber,
                  textColor: Colors.white,
                  splashColor: Colors.deepOrangeAccent,
                  onPressed: () {
                    Navigator.of(context).push(MaterialPageRoute(
                        builder: (context) => CreatePage(title: "Create a vegetable"),
                        settings: RouteSettings(arguments: vegetableRepo),
                      ),
                    );
                  },
                  child: Text (
                    "Create a vegetable",
                    style: TextStyle(fontSize: 20.0),
                  )
              ),
              FlatButton(
                  color: Colors.amber,
                  textColor: Colors.white,
                  splashColor: Colors.deepOrangeAccent,
                  onPressed: () {
                    Navigator.of(context).push(MaterialPageRoute(builder: (context) => ReadPage(title: "All vegetables"),
                      settings: RouteSettings(arguments: vegetableRepo),),);
                  },
                  child: Text (
                    "Read all vegetables",
                    style: TextStyle(fontSize: 20.0),
                  )
              ),
              FlatButton(
                  color: Colors.amber,
                  textColor: Colors.white,
                  splashColor: Colors.deepOrangeAccent,
                  onPressed: () {
                    Navigator.of(context).push(MaterialPageRoute(builder: (context) => UpdatePage(title: "Update a vegetable"),
                        settings: RouteSettings(arguments: vegetableRepo),),);
                  },
                  child: Text (
                    "Update a vegetable",
                    style: TextStyle(fontSize: 20.0),
                  )
              ),
              FlatButton(
                  color: Colors.amber,
                  textColor: Colors.white,
                  splashColor: Colors.deepOrangeAccent,
                  onPressed: () {
                    Navigator.of(context).push(MaterialPageRoute(builder: (context) => DeletePage(title: "Delete a vegetable"),
                      settings: RouteSettings(arguments: vegetableRepo),),);
                  },
                  child: Text (
                    "Delete a vegetable",
                    style: TextStyle(fontSize: 20.0),
                  )
              ),
            ],
          )
      ),
    );
  }

}
