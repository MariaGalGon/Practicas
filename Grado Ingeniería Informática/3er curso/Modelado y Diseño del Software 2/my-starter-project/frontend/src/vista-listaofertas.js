import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-oferta.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import './vista-listaelementos.js';

class VistaListaofertas extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; align-items: center; margin: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="boton_logo">
  <h2 id="titulo_ofertas">Ofertas</h2>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="flex-grow: 1; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-list-box style="align-self: stretch; margin: var(--lumo-space-xl); margin-bottom: var(--lumo-space-xs);" id="lista_ofertas"></vaadin-list-box>
 <vaadin-horizontal-layout theme="spacing" id="cuadro_botones" style="margin: var(--lumo-space-xl); margin-top: var(--lumo-space-xs);">
  <vaadin-button id="vaadinButton" dir="boton_aniadir_oferta">
    Añadir 
  </vaadin-button>
  <vaadin-button id="vaadinButton1" dir="boton_seleccionar">
    Seleccionar 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vista-listaelementos id="lista_seleccionar" style="align-self: stretch; margin: var(--lumo-space-xl);"></vista-listaelementos>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaofertas';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaofertas.is, VistaListaofertas);
