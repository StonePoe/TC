/**
 * Created by stonezhang on 2017/3/8.
 */
var nameGroup = document.getElementsByClassName('nameGroup');
var errorLabel = document.getElementsByClassName('error-info');
function inspect() {
    console.log(nameGroup.className);
    console.log(errorLabel.className);
    nameGroup.className = "form-group nameGroup has-error";
    errorLabel.className = "control-label error-info";
}

