import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import './vista-trabajador.js';

class VistaListatrabajadores extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing-xl" id="vaadinVerticalLayout" style="width: 100%;">
 <vaadin-list-box id="lista_trabajadores" style="align-self: stretch; width: 100%; flex-grow: 1;"></vaadin-list-box>
 <vaadin-button id="vaadinButton" style="flex-grow: 0;" dir="boton_aniadir_trabajador">
   Añadir 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listatrabajadores';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListatrabajadores.is, VistaListatrabajadores);
