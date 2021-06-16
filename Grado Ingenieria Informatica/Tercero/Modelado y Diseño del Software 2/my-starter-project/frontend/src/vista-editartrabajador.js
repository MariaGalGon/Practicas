import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-upload/src/vaadin-upload-file.js';
import '@vaadin/vaadin-upload/src/vaadin-upload.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class VistaEditartrabajador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_administrar_cuentas" style="align-self: stretch; align-items: center; margin: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="boyon_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_administrar_cuentas">Administrar Cuentas</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="flex-grow: 1; align-self: center; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil" style="align-self: center;">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="align-self: stretch; margin: var(--lumo-space-l);">
  <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" dir="cuadro_info">
   <vaadin-text-field label="Identificador" id="identificador" style="align-self: stretch;" dir="id_trabajador" readonly></vaadin-text-field>
   <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout2">
    <vaadin-text-field label="Nombre" id="nombre" dir="nombre_trabajador"></vaadin-text-field>
    <vaadin-text-field label="Apellidos" id="apellidos" dir="apellidos_trabajador"></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-text-field label="Correo" id="correo" style="align-self: stretch;" dir="correo_trabajador"></vaadin-text-field>
   <vaadin-text-field label="Puesto de Trabajo" style="align-self: stretch;" id="puesto" readonly></vaadin-text-field>
   <vaadin-combo-box id="puestoDeTrabajo" style="align-self: stretch;" label="Puesto de Trabajo"></vaadin-combo-box>
   <vaadin-button id="vaadinButton1" dir="boton_contrasenia">
     Generar Contraseña 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout1" style="align-items: center; flex-grow: 1;" dir="cuadro_imagen">
   <img id="imagen_trabajador" style="margin: var(--lumo-space-m);">
   <vaadin-horizontal-layout theme="spacing" id="hueco_upload"></vaadin-horizontal-layout>
   <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout2" style="flex-grow: 1; align-self: stretch; align-items: center; justify-content: flex-end;">
    <vaadin-button id="boton_guardar" style="flex-grow: 0;">
      Guardar 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-editartrabajador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEditartrabajador.is, VistaEditartrabajador);
