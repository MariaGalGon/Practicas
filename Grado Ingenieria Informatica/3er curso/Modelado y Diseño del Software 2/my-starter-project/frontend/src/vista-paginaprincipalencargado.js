import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaPaginaprincipalencargado extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="cabecera" style="flex-grow: 0; align-self: stretch; align-items: center;">
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center; flex-grow: 0;" id="boton_menu">
   <iron-icon icon="lumo:menu"></iron-icon>
  </vaadin-button>
  <img id="boton_logo">
  <h1 style="align-self: center;" id="titulo">Vista de Encargado de Compras</h1>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="cuerpo" style="flex-grow: 1; flex-shrink: 1; align-self: stretch;">
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; align-items: center;" id="logo">
   <h2 style="align-self: center;" id="bienvenida">Bienvenido/a</h2>
   <img style="align-self: center;" id="logo1">
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; align-items: flex-end; padding: var(--lumo-space-m);" id="botones">
   <vaadin-horizontal-layout theme="spacing" style="align-self: flex-end;" id="icono_boton">
    <img id="ver_pedidos">
    <vaadin-button id="boton_ver_pedidos">
      Ver Pedidos 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: flex-end;" id="icono_boton1">
    <img id="perfil">
    <vaadin-button id="boton_perfil">
      Perfil 
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-paginaprincipalencargado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPaginaprincipalencargado.is, VistaPaginaprincipalencargado);
