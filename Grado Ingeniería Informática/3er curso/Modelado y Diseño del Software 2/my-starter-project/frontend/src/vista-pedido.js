import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import './vista-listproductoscomprados.js';
import './vista-listaproductoscomprados.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaPedido extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;" id="cabecera">
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_menu">
   <iron-icon icon="lumo:menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h1 style="align-self: center;" id="titulo_seccion">Pedidos</h1>
 </vaadin-horizontal-layout>
 <h2 style="margin: var(--lumo-space-m);" id="id_compra">ID Compra</h2>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; align-self: stretch;" id="cuerpo">
  <vaadin-horizontal-layout theme="spacing" style="flex-wrap: wrap; flex-grow: 1; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" id="vaadinHorizontalLayout"></vaadin-horizontal-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 0; margin: var(--lumo-space-m); align-self: center;">
   <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout">
    <h3 id="h3">Resumen</h3>
    <p id="id_cliente"></p>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout1">
    <h3 id="h31">Estado</h3>
    <vaadin-combo-box id="combobox_estado"></vaadin-combo-box>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-pedido';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPedido.is, VistaPedido);
