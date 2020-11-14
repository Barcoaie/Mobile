import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:lab3_ma/Domain/Vegetable.dart';
import 'package:lab3_ma/Repository/VegetableRepo.dart';

import '../utils.dart';

class UpdateDetailPage extends StatefulWidget {
  UpdateDetailPage({Key key, this.title}): super(key: key);

  final String title;

  @override
  _UpdateDetailPageState createState() => _UpdateDetailPageState();
}

class _UpdateDetailPageState extends State<UpdateDetailPage> {
  @override
  Widget build(BuildContext context) {
    Arguments args = ModalRoute.of(context).settings.arguments;

    VegetableRepo vegetableRepo = args.vegetableRepo;
    int idx = args.index;

    TextEditingController _vegetableNameController = TextEditingController(text: vegetableRepo.vegetables[idx].name);
    TextEditingController _vegetablePriceController = TextEditingController(text: vegetableRepo.vegetables[idx].price.toString());

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
        title: Text("Update Page - detailed"),
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
                  vegetableRepo.updateVegetable(idx, Vegetable(vegetableName.controller.text, int.parse(vegetablePrice.controller.text)));
                  showDialog(
                      context: context,
                      builder: (context) {
                        return AlertDialog(content: Text("Vegetable updated"),);
                      }
                  );
                },
                child: Text (
                  "Update the vegetable",
                  style: TextStyle(fontSize: 20.0),
                )
            ),
          ],
        ),
      ),
    );
  }
}