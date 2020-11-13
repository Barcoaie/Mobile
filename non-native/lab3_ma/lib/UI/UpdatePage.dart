import 'package:flutter/material.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

class UpdatePage extends StatefulWidget {
  UpdatePage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _UpdatePageState createState() => _UpdatePageState();
}

class _UpdatePageState extends State<UpdatePage> {

  @override
  Widget build(BuildContext context) {
    VegetableRepo vegetableRepo = ModalRoute.of(context).settings.arguments;
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: vegetableRepo.vegetables.isNotEmpty ? ListView.separated(
        itemCount: vegetableRepo.vegetables.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(vegetableRepo.vegetables[index].name),
            onLongPress: () {
              Scaffold.of(context).showSnackBar(SnackBar(content: Text(vegetableRepo.vegetables[index].name),));
            },
          );
        },
        separatorBuilder: (context, index) {
          return Divider();
        },
      ) :
      Center(
        child: Text("Nothing to update!"),
      ),
    );
  }
}