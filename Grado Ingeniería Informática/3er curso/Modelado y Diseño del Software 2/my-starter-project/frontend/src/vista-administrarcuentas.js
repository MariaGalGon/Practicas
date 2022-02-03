import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import './vista-vertrabajadores.js';
import './vista-vercibernautas.js';

class VistaAdministrarcuentas extends PolymerElement {

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
 <vaadin-horizontal-layout theme="spacing" id="cabecera_administrar_cuentas" style="align-self: stretch; align-items: center; margin: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <h2 id="titulo_administrar_cuentas">Administrar Cuentas</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="flex-grow: 1; align-self: center; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="layout_tabs"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="contenido_tabs" style="align-self: stretch; flex-grow: 1; width: 100%; align-items: stretch;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-administrarcuentas';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAdministrarcuentas.is, VistaAdministrarcuentas);
