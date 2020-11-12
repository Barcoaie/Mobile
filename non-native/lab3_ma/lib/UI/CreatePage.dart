import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

class CreatePage extends StatefulWidget {
  CreatePage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _CreatePageState createState() => _CreatePageState();
}

class _CreatePageState extends State<CreatePage> {

  @override
  Widget build(BuildContext context) {
    VegetableRepo vegetableRepo = ModalRoute.of(context).settings.arguments;
    TextEditingController _vegetableNameController = TextEditingController();
    TextEditingController _vegetablePriceController = TextEditingController();

    TextFormField vegetableName = TextFormField(
      controller: _vegetableNameController,
      decoration: InputDecoration(
        border: OutlineInputBorder(),
        labelText: 'Vegetable Name',
      ),
      validator: (value) {
        if(value.isEmpty) {
          return 'Value can\'t be empty';
        }
        return null;
      },
    );

    TextFormField vegetablePrice = TextFormField(
      controller: _vegetablePriceController,
      keyboardType: TextInputType.number,
      inputFormatters: <TextInputFormatter>[FilteringTextInputFormatter.allow(RegExp(r'[0-9]'))],
      decoration: InputDecoration(
        border: OutlineInputBorder(),
        labelText: 'Vegetable Price',
      ),
      validator: (value) {
        if(value.isEmpty) {
          return 'Value can\'t be empty';
        }
        return null;
      },
    );


    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              vegetableName,
              vegetablePrice,
              FlatButton(
                  color: Colors.amber,
                  textColor: Colors.white,
                  splashColor: Colors.deepOrangeAccent,
                  onPressed: () {
                    vegetableRepo.addVegetable(Vegetable(vegetableName.controller.text, int.parse(vegetablePrice.controller.text)));
                    showDialog(
                      context: context,
                      builder: (context) {
                        return AlertDialog(content: Text("Vegetable created"),);
                      }
                    );
                  },
                  child: Text (
                    "Create a vegetable",
                    style: TextStyle(fontSize: 20.0),
                  )
              ),
            ],
          )
      ),
    );
  }
}