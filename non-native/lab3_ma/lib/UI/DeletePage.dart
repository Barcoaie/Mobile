import 'package:flutter/material.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

class DeletePage extends StatefulWidget {
  DeletePage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _DeletePageState createState() => _DeletePageState();
}

class _DeletePageState extends State<DeletePage> {

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
              showDialog(context: context,
                builder: (BuildContext dialogContext) {
                  return AlertDialog(
                    title: Text("Delete Confirmation"),
                    content: Text("Are you sure you want to delete this?"),
                    actions: [
                      FlatButton(onPressed: () { Navigator.of(dialogContext).pop(); }, child: Text("Cancel")),
                      FlatButton(onPressed: () {
                        vegetableRepo.removeVegetable(vegetableRepo.vegetables[index]);
                        setState(() {});
                        Navigator.of(dialogContext).pop();
                        }, child: Text("Continue")),
                    ],
                  );
                },
              );
            },
          );
        },
        separatorBuilder: (context, index) {
          return Divider();
        },
      ) :
      Center(
        child: Text("Nothing to delete!"),
      )
    );
  }
}